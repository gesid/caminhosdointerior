import * as S from "./styles";

import Calendar from "../../assets/calendar.svg";
import Church from "../../assets/church.svg";
import Tree from "../../assets/tree.svg";
import Dining from "../../assets/dining.svg";

export const EventCard = ({
  name = "",
  image = "",
  category = "",
  city = {},
}) => {
  const ICONS = {
    RELIGIOSO: Church,
    AMBIENTAL: Tree,
    CULINARIO: Dining,
    HISTORICO: Calendar,
  };

  return (
    <S.Container>
      <S.Image background={image}></S.Image>
      <S.Content>
        <S.Icon src={ICONS[category]} />
        <S.Description>
          <S.Title>{name}</S.Title>
          <S.SubTitle>{`${city.name}, ${city.sertao}`}</S.SubTitle>
        </S.Description>
      </S.Content>
    </S.Container>
  );
};
