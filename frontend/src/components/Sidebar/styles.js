import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  padding: 8.25rem 2rem 0;
  background-color: #f5a42e;
  height: 100vh;
  width: 20%;
`;

export const Title = styled.h1`
  font-size: 1rem;
  display: flex;
  padding-bottom: 0.5rem;
`;

export const Filter = styled.form`
  display: flex;
  flex-direction: column;
  gap: 0.2rem;
`;

export const InputArea = styled.div`
  display: flex;
  gap: 0.2rem;
`;

export const Text = styled.p``;

export const Input = styled.div`
  width: 1.2rem;
  height: 1.2rem;
  border: 3px solid #f88d22;
  border-radius: 3px;
  background-color: ${({ clicked, theme }) =>
    clicked ? theme.colors.orange : "#fff"};
  cursor: pointer;
`;

export const DropDownContainer = styled.div`
  margin: 2rem 0;
`;

export const DropDown = styled.div`
  font-weight: bold;
  padding: 0.3rem;
  border: 1px solid #000;
  background-color: #f5a42ecc;
  box-shadow: 10px 10px 10px 0cpx rgba(0, 0, 0, 0.25);
  display: flex;
  justify-content: space-between;
`;

export const Icon = styled.img`
  width: 1rem;
`;

export const Option = styled.div`
  font-size: 1rem;
  display: flex;
  position: absolute;
  flex-direction: column;
  background-color: #fff;
  z-index: 999;
  width: 80%;
`;
