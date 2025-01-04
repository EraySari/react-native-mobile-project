export default function groupedDatabyGuideType(data) {
  return data?.reduce((acc, item) => {
    if (!acc[item.guideType]) {
      acc[item.guideType] = [];
    }
    acc[item.guideType].push(item);

    return acc;
  }, {});
}
