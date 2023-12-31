import { useState } from "react";
import * as S from "./styles";
import { Options } from "./Options";
import DropDownArrow from "../../assets/dropDownArrow.svg";

export const DropDown = () => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <S.DropDownContainer onBlur={() => setIsOpen(false)}>
      <S.DropDown onClick={() => setIsOpen(!isOpen)}>
        Cidades
        <S.Icon src={DropDownArrow} />
      </S.DropDown>
      {isOpen && <Options />}
    </S.DropDownContainer>
  );
};
