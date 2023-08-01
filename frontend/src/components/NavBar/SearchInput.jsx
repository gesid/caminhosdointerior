import * as S from "./styles";
import reactLogo from "../../assets/react.svg";

export const SearchInput = () => {
  return (
    <S.SearchOption>
      <img src={reactLogo} alt="" />
      <S.Input placeholder="Pesquisar regiões, cidades ou atrações turísticas" />
    </S.SearchOption>
  );
};
