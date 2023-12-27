import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  
  max-width: 90%; 
  width: 90%;

  margin-bottom: 2rem;
`;

export const TitleArea = styled.div`
  display: flex;
  align-items: center;
  gap: 0.5rem;

  margin-bottom: 1.6rem;
`;

export const Icon = styled.img`
  width: 2rem;
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

  -ms-overflow-style: none;  
  scrollbar-width: none;  

  &::-webkit-scrollbar{
    display: none;
  }

`;

export const CardContainer = styled.div`
  display: grid;
  place-items: center;
  background-image: url(${(props) => props.background});
  background-color: rgba(0, 0, 0, 0.4);
  background-blend-mode: color;
  background-size: 100% 100%;
  position: relative;
  scroll-snap-align: center;

  border-radius: 6px;
  height: 100%;
  width: 100%;

  cursor: pointer;
`;

export const CardWrapper = styled.div`
  display: flex;
  flex-shrink: 0;

  border-radius: 6px;

  height: 14rem;
  width: 20rem;
`;

export const CardTitle = styled.h2`
  font-size: 1rem;
  font-weight: 600;
  color: ${({ theme }) => theme.colors.white};
`;
