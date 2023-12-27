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

export const OndeIr = () => {
  const [regionsWithCities, setRegionsWithCities] = useState([]);

  async function loadRegionsWithCities() {
    try {
      const { data } = await api.get("api/regions/cities");

      const mappedData = data.map((item) => {
        return {
          ...item,
          cities: item.cities.map((city) => ({
            id: city.id,
            image: city.imageBannerUrl,
            title: city.name,
          })),
        };
      });

      setRegionsWithCities(mappedData);
    } catch (error) {
      alert("Erro ao carregar regiões com cidades");
    }
  }

  useEffect(() => {
    loadRegionsWithCities();
  }, []);

  return (
    <>
      <NavBar />
      <CustomStyle.ContentContainer>

        {regionsWithCities.map((regionWithCities) => (
          <CustomStyle.RegionContainer key={regionWithCities.id}>
            <TitledHorizontalMansoryGrid
              title={regionWithCities.name}
              items={regionWithCities.cities}
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
