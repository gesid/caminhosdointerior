import styled from 'styled-components';

export const StyledFooter = styled.div`
    background-color: #E4E4D3;
    width: auto;
    height: 202px;
    padding:0 5rem;
    font-size: 1rem;
    color: black;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    
    h5{
        margin-top:auto;
        text-decoration: solid;
    }
;

`
export const StyledList = styled.div`
    gap:1rem;
    flex-direction: column;
    font-size: 1rem;
    color: black;
    display: flex;

    li{ 
        list-style: none;
    }
;
`

export const StyledSocialMedia = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 1rem;
    .logo{
        display:flex;
        gap:0.5rem;
     }
`



