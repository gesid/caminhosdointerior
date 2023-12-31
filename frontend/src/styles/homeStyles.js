// Estilos da tela de home (se necessario )
import { styled } from "styled-components";
import background from "../assets/backgroundInputLogo.svg";

export const Header = styled.header`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
`;

export const HeaderContent = styled.div`
  background: url(${background}) no-repeat;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  width: 90%;
  background-size: cover;
  padding: 1rem 0px;
  border-radius: 4px;
`;

export const Logo = styled.img`
  width: 563px;
  height: 156px;
  margin-bottom: 4rem;
`;

export const Events = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  width: 100%;
  margin: 2rem 0rem;
`;
