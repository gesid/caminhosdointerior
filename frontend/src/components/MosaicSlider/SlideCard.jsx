import { useNavigate } from "react-router-dom";
import * as S from "./styles";

export const SlideCard = ({ image, title, id}) => {
  const navigate = useNavigate();

  return (
    <S.CardContainer background={image} onClick={() => navigate(`/${id}`)}>
      <S.CardTitle>{title}</S.CardTitle>
    </S.CardContainer>
  );
};