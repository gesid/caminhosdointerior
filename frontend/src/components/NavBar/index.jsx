import { useLocation } from "react-router-dom";

import * as S from "./styles";
import Logo from "../../assets/Logo.svg";
import { useCurrentStep } from "../../context/CurrentStep.context.";
import { SearchInput } from "./SearchInput";

const NAV_LINKS = [
  {
    pathname: "/",
    label: "Home",
  },
  {
    pathname: "/ondeIr",
    label: "Onde Ir?",
  },
  {
    pathname: "/o-que-fazer",
    label: "O que fazer?",
  },
];

export const NavBar = () => {
  const [currentStep] = useCurrentStep();
  const { pathname } = useLocation();

  return (
    <S.Container>
      <img src={Logo} />

      {currentStep !== "/" && <SearchInput />}

      <S.Actions>
        {NAV_LINKS.map((link) => (
          <S.Option
            key={link.pathname}
            to={link.pathname}
            currentStep={pathname === link.pathname}
          >
            {link.label}
          </S.Option>
        ))}
      </S.Actions>
    </S.Container>
  );
};
