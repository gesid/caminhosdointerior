import { Card } from "./Card";

import * as S from "./styles";

export const Slider = ({ title, icon, items }) => {
  return (
    <S.Container>
      <S.TitleArea>
        <S.Icon src={icon} />
        <S.Title> {title}</S.Title>
      </S.TitleArea>
      <S.Cards>
        {items.map((card) => (
          <S.CardWrapper key={card.id}>
            <Card
              id={card.id}
              image={card.image}
              title={card.title}
            />
          </S.CardWrapper>
        ))}
      </S.Cards>
    </S.Container>
  );
};
