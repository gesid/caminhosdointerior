import { StyledBannerWhereGo, StyledMainPage } from "../components/MosaicSlider/styles";
import Footer from "../components/footer/Footer";
import { useCurrentStep } from "../context/CurrentStep.context.";
import { MosaicSlider } from "../components/MosaicSlider/MosaicSlider";
import cards from "../data/cards";
import cardsInhamuns from "../data/cardsInhamuns";
import cardsCariri from "../data/cardsCariri";
import cardsPontosTuristicos from "../data/cardsPontosTuristicos";
import * as S from "../styles/homeStyles";
import { useEffect } from "react";

export const OndeIr = () => {

    const sliders = [
        {
            title: "Sertões de Crateús",
            cards: cards,
        },
        {
            title: "Sertões dos Inhamuns",
            cards: cardsInhamuns,
        },
        {
            title: "Cariri",
            cards: cardsCariri,
        }
    ];


    const [currentStep, setCurrentStep] = useCurrentStep();

    useEffect(() => {
        setCurrentStep(1);
    }, []);

    return (
        <>
            <S.Events>
                     <MosaicSlider {...sliders[0]} />
                {/* {sliders.map((slider) => (
                    <MosaicSlider {...slider} key={slider.title} />
                ))}*/}
            </S.Events>
            <StyledMainPage>
                <StyledBannerWhereGo>
                    <img src="src/assets/OndeIrImage.png" className="StyleBanner" alt="Where Go Banner Advise"></img>
                </StyledBannerWhereGo>
            </StyledMainPage>
            <Footer />
        </>
    );
}