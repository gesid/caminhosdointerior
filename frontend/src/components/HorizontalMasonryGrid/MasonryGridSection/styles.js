import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-shrink: 0;
  height: 100%;
  
  width: ${props => props.width};

  margin-right: 1rem;
`;
