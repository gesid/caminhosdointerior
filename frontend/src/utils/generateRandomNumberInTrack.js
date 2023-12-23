export function generateRandomNumberInTrack(min, max) {
  const randomNumber = Math.random();

  const interval = max - min;
  const numberInInterval = randomNumber * interval;

  const finalNumber = numberInInterval + min;

  return Math.floor(finalNumber);
}