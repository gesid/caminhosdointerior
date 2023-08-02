import * as S from "./styles";
import seatch from "../../assets/search.svg";

export const SearchInput = () => {
  return (
    <S.SearchOption>
      <img src={seatch} alt="" />
      <S.Input placeholder="Pesquisar regiões, cidades ou atrações turísticas" />
    </S.SearchOption>
  );
};
