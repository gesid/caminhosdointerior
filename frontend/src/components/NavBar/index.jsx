import * as S from "./styles";
import Logo from "../../assets/Logo.svg";
import { useCurrentStep } from "../../context/CurrentStep.context.";
import { SearchInput } from "./SearchInput";
import { useNavigate } from "react-router-dom";

export const NavBar = () => {
  const [currentStep] = useCurrentStep();
  const navigate = useNavigate();

  return (
    <S.Container>
      <img src={Logo} />
      {currentStep !== 1 && <SearchInput />}
      <S.Actions>
        <S.Option onClick={() => navigate("/")} currentStep={currentStep === 1}>
          Home
        </S.Option>
        <S.Option
          onClick={() => navigate("/ondeIr")}
          currentStep={currentStep === 2}
        >
          Onde ir?
        </S.Option>
        <S.Option href="/" currentStep={currentStep === 3}>
          O que fazer?
        </S.Option>
      </S.Actions>
    </S.Container>
  );
};
