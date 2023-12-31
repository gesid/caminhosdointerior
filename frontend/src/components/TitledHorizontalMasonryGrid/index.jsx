import { HorizontalMasonryGrid } from "../HorizontalMasonryGrid";
import * as S from "./styles";

export const TitledHorizontalMansoryGrid = ({ items, title }) => {
  return (
    <S.Container>
      <S.TitleArea>
        <S.Title>{title}</S.Title>
      </S.TitleArea>
      
      <HorizontalMasonryGrid data={items} />
    </S.Container>
  );
};
