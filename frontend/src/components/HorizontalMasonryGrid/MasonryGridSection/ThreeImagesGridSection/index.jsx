import { useMemo } from "react";

import { Card } from "../../../Slider/Card";

import * as DefaultStyle from "../styles";
import * as CustomStyle from "./styles";

export function ThreeImagesGridSection({ data: section }) {
  const {
    topImage,
    bottomLeftImage,
    bottomRightImage,
  } = useMemo(() => {
    return {
      topImage: section.data[0],
      bottomLeftImage: section.data[1],
      bottomRightImage: section.data[2],
    }
  }, [section]);

  return (
    <DefaultStyle.Container width={section.width}>
      <CustomStyle.ContentContainer>
        <CustomStyle.ContentSection height={section.sizingOptions.topImageHeight}>
          <Card
            id={topImage.id}
            image={topImage.image}
            title={topImage.title}
          />
        </CustomStyle.ContentSection>

        <CustomStyle.BottomSection height={section.sizingOptions.bottomImagesHeight}>
          <CustomStyle.Item width={section.sizingOptions.bottomLeftImageWitdh}>
            <Card
              id={bottomLeftImage.id}
              image={bottomLeftImage.image}
              title={bottomLeftImage.title}
            />
          </CustomStyle.Item>

          <CustomStyle.Item width={section.sizingOptions.bottomRightImageWitdh}>
            <Card
              id={bottomRightImage.id}
              image={bottomRightImage.image}
              title={bottomRightImage.title}
            />
          </CustomStyle.Item>
        </CustomStyle.BottomSection>
      </CustomStyle.ContentContainer>
    </DefaultStyle.Container>
  );
}
