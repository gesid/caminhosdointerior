import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 80%; // TODO: verificar padding da pagina
  gap: 2.5rem;
  justify-content: center;
`;

export const TitleArea = styled.div`
  display: flex;
  align-items: center;
  gap: 0.4rem;
`;

export const Icon = styled.img`
  width: 3rem;
`;

export const Title = styled.h1`
  font-size: 1.5rem;
  font-weight: bold;
`;

export const Cards = styled.div`
  display: flex;
  gap: 1.5rem;
  overflow-x: scroll;
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  align-items: center;
  justify-content: center;
`;

export const CardContainer = styled.div`
  width: 10rem;
  height: 80%;
  /*   background-image: url(${(props) => props.background}); */
  background-color: red;
  background-size: cover;
`;

export const CardTitle = styled.h2`
  font-size: 1rem;
  font-weight: 600;
`;
