import { useEffect, useState } from "react";
import {
  StyledBannerWhereGo,
  StyledMainPage,
} from "../components/MosaicSlider/styles";
import Footer from "../components/footer/Footer";

import { NavBar } from "../components/NavBar";

import * as CustomStyle from "../styles/ondeIrStyles";

import { api } from "../services/api";
import { TitledHorizontalMansoryGrid } from "../components/TitledHorizontalMasonryGrid";

export const OQueFazer = () => {
  const [touristAttractionCategoriesWithAttractions, setTouristAttractionCategoriesWithAttractions] = useState([]);

  async function loadTouristAttractionCategoriesWithAttractions(){
    try {
      const { data } = await api.get("api/tourist-attractions-with-categories");

      const mappedData = data.map((touristAttractionCategoryWithAttractions) => {

        const items = [];

        touristAttractionCategoryWithAttractions.locations.forEach((item) => {
          items.push({
            id: item.id,
            image: item.bannerImage,
            title: item.name,
          })
        });

        touristAttractionCategoryWithAttractions.events.forEach((item) => {
          items.push({
            id: item.id,
            image: item.bannerImage,
            title: item.name,
          })
        })

        const shuffledArray = items.sort(() => Math.random() - 0.5);

        return {
          id: touristAttractionCategoryWithAttractions.id,
          title: touristAttractionCategoryWithAttractions.name,
          icon: touristAttractionCategoryWithAttractions.iconUrl,
          items: shuffledArray
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
      <CustomStyle.ContentContainer>

        {touristAttractionCategoriesWithAttractions.map((touristAttractionCategoryWithAttractions) => (
          <CustomStyle.RegionContainer key={touristAttractionCategoryWithAttractions.id}>
            <TitledHorizontalMansoryGrid
              title={touristAttractionCategoryWithAttractions.title}
              items={touristAttractionCategoryWithAttractions.items}
            />
          </CustomStyle.RegionContainer>
        ))}
      </CustomStyle.ContentContainer>
      <StyledMainPage>
        <StyledBannerWhereGo>
          <img
            src="src/assets/OndeIrImage.png"
            className="StyleBanner"
            alt="Where Go Banner Advise"
          ></img>
        </StyledBannerWhereGo>
      </StyledMainPage>
      <Footer />
    </>
  );
};
