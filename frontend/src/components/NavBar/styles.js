import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  background-color: ${(props) => props.theme.colors.orange};
  padding:0  10rem;
  img {
    width: 12rem;
    padding: 0.5rem;
  }
`;

export const Actions = styled.ul`
  display: flex;
  align-items: center;
  gap: 1rem;
`;

export const Option = styled.p`
  color: #000;
  text-decoration: none;

  font-weight: ${({ currentStep }) => currentStep && "bold"};
`;
