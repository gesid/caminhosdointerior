import LogoWhite from "../assets/LogoWhite.svg";
import { Search } from "../components/Search";
import * as S from "../styles/homeStyles";

export const Home = () => {
  return (
    <S.Header>  
           <S.Logo src={LogoWhite} alt="Logo caminhos do interior"/>
           <Search/>
    </S.Header>
  )
}
