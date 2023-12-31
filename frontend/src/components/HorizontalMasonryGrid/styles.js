import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: row;

  overflow-x: scroll;
  width: 100%;

  -ms-overflow-style: none;  
  scrollbar-width: none;  

  height: 16rem;
  margin-top: 1rem;

  &::-webkit-scrollbar{
    display: none;
  }
`;