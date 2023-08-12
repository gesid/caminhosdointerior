// Estilos da tela de home (se necessario )
import { styled } from "styled-components";
import background from "../assets/backgroundInputLogo.svg";

export const Header = styled.header`
    width: 90%;
    background: url(${background}) no-repeat center center ;
    margin: auto;
    display: flex;
    padding: 3.5rem;
    flex-direction: column;
    justify-content: center;
    align-items: center;
`;

export const Logo = styled.img`
  width: 563px;
  height: 156px;
  margin-bottom: 4rem;
`;

export const Events = styled.div`
  display: flex;
  flex-direction: column;
/*   gap: 2.5rem; */
`;
