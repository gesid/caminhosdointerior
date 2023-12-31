import { useNavigate } from "react-router-dom";
import * as S from "./styles";

export const Card = ({ image, title, id }) => {
  const navigate = useNavigate();

  function handleClick(){
    alert("Em Breve");
  }

  return (
    <S.CardContainer background={image} onClick={handleClick}>
      <S.CardTitle>{title}</S.CardTitle>
    </S.CardContainer>
  );
};
