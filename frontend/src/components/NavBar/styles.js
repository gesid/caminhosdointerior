import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 80%;
  margin: 0 auto;
  background-color: ${(props) => props.theme.colors.orange};
  padding: 0.6rem 8.25rem;
  border-radius: 0px 0px 20px 20px;
  box-shadow: 0px 0.5rem 0.5rem 0px rgba(0, 0, 0, 0.25);

  img {
    width: 12rem;
  }
`;

export const Actions = styled.ul`
  display: flex;
  align-items: center;
  gap: 1rem;
`;

export const Option = styled.a`
  color: #000;
  text-decoration: none;

  font-weight: ${({ currentStep }) => currentStep && "bold"};
`;

export const SearchOption = styled.div`
  display: flex;
  flex: 0.9;
  background-color: ${({ theme }) => theme.colors.white};
  border-radius: 15px;
  align-items: center;
  padding: 0.7rem;
  gap: 1rem;
  img {
    width: 1.5rem;
  }
`;

export const Input = styled.input`
  border: 0;
  outline: 0;
  flex: 1;
  border-radius: inherit;
  font-size: 1rem;
`;
