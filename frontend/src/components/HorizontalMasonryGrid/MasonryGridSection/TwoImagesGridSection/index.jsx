

import { Card } from "../../../Slider/Card";

import * as DefaultStyles from "../styles";
import * as CustomStyle from "./styles";
import { useMemo } from "react";

export function TwoImagesGridSection({ data: section }) {
  const { topImage, bottomImage } = useMemo(() => {
    return {
      topImage: section.data[0],
      bottomImage: section.data[1],
    }
  }, [section]);

  return (
    <DefaultStyles.Container width={section.width}>
      <CustomStyle.ContentContainer>
        <CustomStyle.Item height={section.sizingOptions.topImageHeight}>
          <Card
            id={topImage.id}
            image={topImage.image}
            title={topImage.title}
          />
        </CustomStyle.Item>

        <CustomStyle.Item height={section.sizingOptions.bottomImageHeight}>
          <Card
            id={bottomImage.id}
            image={bottomImage.image}
            title={bottomImage.title}
          />
        </CustomStyle.Item>
      </CustomStyle.ContentContainer>

    </DefaultStyles.Container>
  );
}
