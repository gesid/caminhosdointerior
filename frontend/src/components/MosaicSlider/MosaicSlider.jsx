import { SlideCard } from "./SlideCard";
import PhotoAlbum from "react-photo-album";
import * as S from "./styles";
import React, { useLayoutEffect } from "react";


// 0 1 2
// 3 4 5
// 6 7 8

let image1 = 0;
let image2 = 1;
let image3 = 2;

export const MosaicSlider = ({ title, cards }) => {
  const [targetRowHeight, setTargetRowHeight] = React.useState(300);
  const [columns, setColumns] = React.useState(5);
  const [spacing, setSpacing] = React.useState(30);
  const [padding, setPadding] = React.useState(10);

  useLayoutEffect(() => {
    const viewportSize = window.innerWidth;
    setColumns(viewportSize < 480 ? 2 : viewportSize < 900 ? 3 : 5);
    setSpacing(viewportSize < 480 ? 10 : viewportSize < 900 ? 20 : 30);
    setPadding(viewportSize < 480 ? 10 : viewportSize < 900 ? 20 : 30);
    setTargetRowHeight(viewportSize < 480 ? 100 : viewportSize < 900 ? 150 : 200);
  }, []);

  const photos = cards.map((card, index) => {

    const width = 400;
    const maxHeight = 600;
    const middleHeight = (maxHeight / 2) - 20;
    let height = 0;

    if (index === image1) {
      height = maxHeight;
    } else {
      height = middleHeight;
    }

    const objeto = {
      id: card.id,
      name: card.name,
      src: card.image,
      width: card.width ? card.width : 400,
      height: card.heigh ? card.heigh : 260
    };

    if (image1 == index) {
      image1 += 3;
    }

    if (image2 == index) {
      image2 += 3;
    }

    if (image3 == index) {
      image3 += 3;
    }

    return objeto;
  });

  return (
    <S.Container>
      <S.TitleArea>
        <S.Title> {title}</S.Title>
      </S.TitleArea>

      <PhotoAlbum layout="columns" photos={photos} columns={columns} spacing={7} padding={0} targetRowHeight={targetRowHeight} />
      {/* <S.Cards>
        {cards.map((card) => (
          <S.SlideCardContainer key={card.id}
            background={card.image}>
            <SlideCard
              id={card.id}
              image={card.image}
              title={card.title}
              key={card.id}
            />
          </S.SlideCardContainer>
        ))}
      </S.Cards> */}
    </S.Container>
  );
};