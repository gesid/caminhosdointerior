import { StyledNotFoundPageText1 } from "../components/footer/styled";
import { StyledNotFoundPageText2 } from "../components/footer/styled";
import { StyledNotFoundImage } from "../components/footer/styled";

import interjeicao from '../assets/interjeicao.svg'
import notfound from '../assets/notfound.svg'
import figuresNotFound from '../assets/figuresNotFound.png'
import { NavBar } from "../components/NavBar";

export const Page404 = () => {
  return (
    <div>
      <NavBar />
      <StyledNotFoundPageText1>
        <div className="text1">
          <div className="svg-text">
            <img src={interjeicao} alt="Interjeição arre egua" />
          </div>
        </div>
      </StyledNotFoundPageText1>
      <StyledNotFoundPageText2>
        <div className="text2">
          <div className="svg-text">
            <img src={notfound} alt="Página não encontrada" />
          </div>
        </div>
      </StyledNotFoundPageText2>
      <StyledNotFoundImage src={figuresNotFound} alt="Elementos do NotFound" />
    </div>
  );
};