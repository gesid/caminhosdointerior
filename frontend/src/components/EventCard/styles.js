import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  cursor: pointer;
`;

export const Image = styled.img`
  width: 80%;
  height: 90%;
  background-image: url(${({ background }) => background});
  background-size: 100% 100%;
  border-radius: 10px;
`;
export const Icon = styled.img`
  width: 2rem;
`;
export const Content = styled.div`
  display: flex;
  gap: 0.5rem;
`;

export const Description = styled.div`
  display: flex;
  flex-direction: column;
`;

export const Title = styled.h2`
  font-size: 1rem;
`;

export const SubTitle = styled.p`
  color: #868686;
  font-size: 0.8rem;
`;
