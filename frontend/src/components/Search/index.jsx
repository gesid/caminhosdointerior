import search from "../../assets/search.svg"
import * as S from "./styles";

export const Search = () => {
    return (
        <S.Search>  
            <S.LabelSearch htmlFor="inputSearch">
                <S.IconSearch src={search} alt="Icon search" />
            </S.LabelSearch>
            <S.InputSearch type="text" name="inputSearch" id="inputSearch" placeholder="Pesquisar regiões, cidades ou atrações turísticas"/>
        </S.Search>
    )
}