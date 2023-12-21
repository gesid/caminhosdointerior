import styled from 'styled-components';
import React from 'react';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  gap: 2.5rem;
  justify-content: center;
  padding: 2.25rem 2rem;

  .react-photo-album-photo{
    background-color: rgba(0, 0, 0, 0.4);
    background-blend-mode: color;
  }
`;

export const TitleArea = styled.div`
  display: flex;
  align-items: center;
  gap: 0.5rem;
`;

export const Title = styled.h1`
  font-size: 1.5rem;
  font-weight: bold;
`;

export const CardContainer = styled.div`
  display: grid;
  place-items: center;
  min-width: 100%; /* Ajuste a largura conforme necessário */
  background-size: cover;
  background-position: center;
  background-image: url(${(props) => props.background});  
  position: relative;
  scroll-snap-align: center;
  min-height: 15rem; 
}
`;

export const Cards = styled.div`
  display: flex;
  gap: 1.5rem;
  overflow-x: auto; /* ou overflow-x: scroll; */
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  align-items: center;
`;

export const SlideCardContainer = styled.div`
  min-height: 15rem;
  min-width: 25%;
  scroll-snap-align: center;
`;


export const CardTitle = styled.h2`
  font-size: 1rem;
  font-weight: 600;
  color: ${({ theme }) => theme.colors.white};
`;

export const StyledMainPage = styled.div`
    margin-left:1.8rem;
    margin-right:1.8rem;
`

export const StyledBannerWhereGo = styled.div`
    margin-top:10rem;
    margin-bottom:9rem;

    .StyleBanner{
        width: 82rem;
        height: 21.5rem;
       
    }
`
