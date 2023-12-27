import styled from "styled-components";

export const Container = styled.div`
  height: 100%;
  display: flex;
  gap: 2.5rem;
  min-height: 100vh;
  flex: 1;
  overflow: hidden;
`;

export const ContentContainer = styled.div`
  display: flex;
  flex-direction: column;

  align-items: center;
  justify-content: center;

  width: 100%;
  margin-top: 2rem;
`;

export const RegionContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  width: 90%;
  margin-bottom: 2rem;
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
