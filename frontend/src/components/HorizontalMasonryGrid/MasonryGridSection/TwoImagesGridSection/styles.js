import styled from "styled-components";

export const ContentContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  
  height: 100%;
  width: 100%;
`;

export const Item = styled.div`
  display: flex;
  height: ${props => props.height};

  background-color: red;
  width: 100%;
`;