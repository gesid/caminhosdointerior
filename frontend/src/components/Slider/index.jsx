import { HorizontalMasonryGrid } from "../HorizontalMasonryGrid";

import * as S from "./styles";

export const Slider = ({ title, icon, cards }) => {
  return (
    <S.Container>
      <S.TitleArea>
        <S.Icon src={icon} />
        <S.Title> {title}</S.Title>
      </S.TitleArea>
      <HorizontalMasonryGrid data={cards} />
    </S.Container>
  );
};
