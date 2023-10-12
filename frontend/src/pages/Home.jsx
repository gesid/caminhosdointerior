import LogoWhite from "../assets/LogoWhite.svg";
import Calendar from "../assets/calendar.svg";
import Church from "../assets/church.svg";
import Tree from "../assets/tree.svg";
import Dining from "../assets/dining.svg";

import { Search } from "../components/Search";
import { Slider } from "../components/Slider";
import Footer from "../components/footer/Footer";

import cards from "../data/cards";

import * as S from "../styles/homeStyles";
import { useEffect } from "react";
import { useCurrentStep } from "../context/CurrentStep.context.";
import { NavBar } from "../components/NavBar";

const sliders = [
  {
    title: "Atrações em destaque",
    icon: Calendar,
    cards: cards,
  },
  {
    title: "Lugares para quem ama turismo religioso",
    icon: Church,
    cards: cards,
  },
  {
    title: "Lugares para quem ama turismo ambiental",
    icon: Tree,
    cards: cards,
  },
  {
    title: "Lugares para quem ama gastronomia",
    icon: Dining,
    cards: cards,
  },
];

export const Home = () => {
  const [_currentStep, setCurrentStep] = useCurrentStep();

  useEffect(() => {
    setCurrentStep(1);
  }, []);

  return (
    <>
      <NavBar />
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
