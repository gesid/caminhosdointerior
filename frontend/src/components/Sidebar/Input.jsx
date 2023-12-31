import * as S from "./styles";
import { useSidebar } from "../../context/Sidebar.context";

export const Input = ({ actionType, payload, title, filter }) => {
  const { dispatch } = useSidebar();

  return (
    <S.InputArea>
      <S.Input
        clicked={filter == payload}
        onClick={() => {
          dispatch({
            type: actionType,
            payload: payload,
          });
        }}
      />
      <S.Text>{title}</S.Text>
    </S.InputArea>
  );
};
