import React from "react";
import { StyledFooter, StyledList } from "./styled"; 
import List from "./StyledList";
import RedesSociais from "./RedesSociais";

const Footer = () => {
    return (
      <StyledFooter>
        <List/>
        <h5> 2023 - TODOS OS DIREITOS RESERVADOS </h5>
        <RedesSociais/>  
      </StyledFooter>
    );
};

export default Footer;