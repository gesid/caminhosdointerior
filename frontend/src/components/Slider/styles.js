import { styled } from "styled-components";
import {motion} from 'framer-motion'

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%; // TODO: verificar padding da pagina
  gap: 2.5rem;
  justify-content: center;
  padding: 0 2rem;
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

export const Cards = styled.div(motion.div)`
  display: flex;
  gap: 1.5rem;
  overflow-x: scroll;
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  align-items: center;
`;

export const CardContainer = styled.div`
  width: 20rem;
  height: 80%;
  /*   background-image: url(${(props) => props.background}); */
  background-color: red;
  background-size: cover;
  position: relative;
`;

export const CardTitle = styled.h2`
  font-size: 1rem;
  font-weight: 600;
`;
