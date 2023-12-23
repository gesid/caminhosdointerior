import LogoWhite from "../assets/LogoWhite.svg";
import Calendar from "../assets/calendar.svg";
import Church from "../assets/church.svg";
import Tree from "../assets/tree.svg";
import Dining from "../assets/dining.svg";

import { Search } from "../components/Search";
import { Slider } from "../components/Slider";
import Footer from "../components/footer/Footer";
import cardsPontosTuristicos from "../data/cardsPontosTuristicos";
import * as S from "../styles/homeStyles";
import { useEffect } from "react";
import { useCurrentStep } from "../context/CurrentStep.context.";

const sliders = [
  {
    title: "Atrações em destaque",
    icon: Calendar,
    cards: cardsPontosTuristicos,
  },
  {
    title: "Lugares para quem ama turismo religioso",
    icon: Church,
    cards: cardsPontosTuristicos,
  },
  {
    title: "Lugares para quem ama turismo ambiental",
    icon: Tree,
    cards: cardsPontosTuristicos,
  },
  {
    title: "Lugares para quem ama gastronomia",
    icon: Dining,
    cards: cardsPontosTuristicos,
  },
];

export const Home = () => {
  const [currentStep, setCurrentStep] = useCurrentStep();

  useEffect(() => {
    setCurrentStep(1);
  }, []);

  return (
    <>
      <S.Header>
        <S.Logo src={LogoWhite} alt="Logo caminhos do interior" />
        <Search />
      </S.Header>
      <S.Events>
        {sliders.map((slider) => (
          <Slider {...slider} key={slider.title} />
        ))}
      </S.Events>
      <Footer />
    </>
  );
};