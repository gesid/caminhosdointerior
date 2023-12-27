import { useEffect, useState } from "react";

import { NavBar } from "../components/NavBar";

import LogoWhite from "../assets/LogoWhite.svg";

import { Search } from "../components/Search";
import { Slider } from "../components/Slider";
import Footer from "../components/footer/Footer";
import * as S from "../styles/homeStyles";

import { api } from "../services/api";

export const Home = () => {
  const [touristAttractionCategoriesWithAttractions, setTouristAttractionCategoriesWithAttractions] = useState([]);

  async function loadTouristAttractionCategoriesWithAttractions(){
    try {
      const { data } = await api.get("api/tourist-attractions-with-categories");

      const mappedData = data.map((touristAttractionCategoryWithAttractions) => {
        return {
          id: touristAttractionCategoryWithAttractions.id,
          title: `Lugares para quem ama ${touristAttractionCategoryWithAttractions.name.toLowerCase()}`,
          icon: touristAttractionCategoryWithAttractions.iconUrl,
          items: touristAttractionCategoryWithAttractions.locations.map((item) => {
            return {
              id: item.id,
              image: item.bannerImage,
              title: item.name,
            }
          })
        }
      });
      
      setTouristAttractionCategoriesWithAttractions(mappedData);
    } catch (error) {
      alert("Erro ao carregar lista de categorias de atrações turísticas com atrações");
    }
  }

  useEffect(() => {
    loadTouristAttractionCategoriesWithAttractions();
  }, []);

  return (
    <>
      <NavBar />
      <S.Header>
        <S.HeaderContent>
          <S.Logo src={LogoWhite} alt="Logo caminhos do interior" />
          <Search />
        </S.HeaderContent>
      </S.Header>
      <S.Events>
        {touristAttractionCategoriesWithAttractions.map((slider) => (
          <Slider {...slider} key={slider.id} />
        ))}
      </S.Events>
      <Footer />
    </>
  );
};