import styled from "styled-components";

export const ContentContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  
  height: 100%;
  width: 100%;
`;

export const ContentSection = styled.div`
  display: flex;
  height: ${props => props.height};

  width: 100%;
`;

export const BottomSection = styled(ContentSection)`
  flex-direction: row;
  justify-content: space-between;
`;

export const Item = styled.div`
  display: flex;
  height: 100%;
  width: ${props => props.width};
`;