import { Card } from "./Card";
import * as S from "./styles";

export const Slider = ({ title, icon, cards }) => {
  return (
    <S.Container>
      <S.TitleArea>
        <S.Icon src={icon} />
        <S.Title> {title}</S.Title>
      </S.TitleArea>
      <S.Cards>
        {cards.map((card) => (
          <Card
            id={card.id}
            image={card.image}
            title={card.title}
            key={card.id}
          />
        ))}
      </S.Cards>
    </S.Container>
  );
};
