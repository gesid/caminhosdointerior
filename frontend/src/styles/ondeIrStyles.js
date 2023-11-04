import styled from "styled-components";

export const Container = styled.div`
  height: 100%;
  display: flex;
  gap: 2.5rem;
  min-height: 100vh;
  flex: 1;
  overflow: hidden;
`;

export const Events = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-auto-rows: minmax(30%, auto);
  grid-auto-flow: row;
  height: 100%;
  gap: 1rem;
  overflow-y: scroll;
`;

export const Content = styled.div`
  padding-top: 7rem;
  display: flex;
  flex-direction: column;
  flex: 1;
  gap: 1rem;

  h3 {
    font-size: 1.5rem;
  }
`;
