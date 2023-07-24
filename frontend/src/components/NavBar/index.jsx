import * as S from "./styles";
import Logo from "../../assets/Logo.svg";
import { useCurrentStep } from "../../context/CurrentStep.context.";

export const NavBar = () => {
  const [currentStep] = useCurrentStep();

  return (
    <S.Container>
      <img src={Logo} />
      <S.Actions>
        <S.Option href="/" currentStep={currentStep === 1}>
          Home
        </S.Option>
        <S.Option href="" currentStep={currentStep === 2}>
          Onde ir?
        </S.Option>
        <S.Option href="/" currentStep={currentStep === 3}>
          O que fazer?
        </S.Option>
      </S.Actions>
    </S.Container>
  );
};
