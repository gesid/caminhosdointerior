
import * as S from "./styles";
import { Input } from "./Input";
import { actionTypes, useSidebar } from "../../context/Sidebar.context";


export const Options = () => {
  const { state } = useSidebar();

  return (
    <S.Option>
      <Input
        actionType={actionTypes.UPDATE_CIDADE}
        payload={"cidade"}
        filter={state.cidade}
        title={"idade"}
      />
      <Input
        actionType={actionTypes.UPDATE_CIDADE}
        payload={"cidade"}
        filter={state.cidade}
        title={"idade"}
      />
      <Input
        actionType={actionTypes.UPDATE_CIDADE}
        payload={"cidade"}
        filter={state.cidade}
        title={"idade"}
      />
       <Input
        actionType={actionTypes.UPDATE_CIDADE}
        payload={"cidade"}
        filter={state.cidade}
        title={"idade"}
      />
      <Input
        actionType={actionTypes.UPDATE_CIDADE}
        payload={"cidade"}
        filter={state.cidade}
        title={"idade"}
      />
      <Input
        actionType={actionTypes.UPDATE_CIDADE}
        payload={"cidade"}
        filter={state.cidade}
        title={"idade"}
      />
    </S.Option>
  );
};
