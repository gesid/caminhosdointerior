import { Card } from "../../../Slider/Card";
import * as S from "../styles";

export function OneImageGridSection({ data: section }){
  return (
    <S.Container width={section.width}>
      {section.data.map((image) => (
        <Card key={image.id} id={image.id} image={image.image} title={image.title} />
      ))}
    </S.Container>
  )
}