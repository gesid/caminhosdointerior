import * as S from "./styles";
import { actionTypes, useSidebar } from "../../context/Sidebar.context";
import SideBarFilters from "../../utils/SideBarFilters";
import { useState } from "react";
import { Input } from "./Input";
import { DropDown } from "./DropDown";

export const SideBar = () => {
  const { state, dispatch } = useSidebar();

  return (
    <S.Container>
      <S.Filter>
        <S.Title>Sertões</S.Title>
        <Input
          actionType={actionTypes.UPDATE_SERTAO}
          filter={state.sertao}
          payload={SideBarFilters.SERTOES.INHAMUS}
          title={"Inhamus"}
        />
        <Input
          actionType={actionTypes.UPDATE_SERTAO}
          filter={state.sertao}
          payload={SideBarFilters.SERTOES.CRATEUS}
          title={"Cratéus"}
        />
      </S.Filter>

      <DropDown />
      
      <S.Filter>
        <Input
          actionType={actionTypes.UPDATE_EVENTO}
          filter={state.evento}
          payload={SideBarFilters.TURISMO.RELIGIOSO}
          title={"Religioso"}
        />

        <Input
          actionType={actionTypes.UPDATE_EVENTO}
          filter={state.evento}
          payload={SideBarFilters.TURISMO.AMBIENTAL}
          title={"Ambiental"}
        />
        <Input
          actionType={actionTypes.UPDATE_EVENTO}
          filter={state.evento}
          payload={SideBarFilters.TURISMO.CULINARIO}
          title={"Culinario"}
        />
        <Input
          actionType={actionTypes.UPDATE_EVENTO}
          filter={state.evento}
          payload={SideBarFilters.TURISMO.HISTORICO}
          title={"Historico"}
        />
      </S.Filter>
    </S.Container>
  );
};
