import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;

  background: gray;
  width: 90%;
`;

const Title = styled.h1``;

const CardsContainer = styled.div`
  display: flex;

  flex-direction: row;
  width: 100%;

  overflow-x: scroll;
`;

const cardStyle = {
  width: "10rem",
  height: "10rem",
  background: "green",
  margin: "0rem 2rem",
  borderRadius: "16px",
  flexShrink: 0
};

export const TestSlider = () => {
  return (
    <Container>
      <Title>Título da Categoria</Title>

      <CardsContainer>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
        <div style={cardStyle}></div>
      </CardsContainer>
    </Container>
  );
};
