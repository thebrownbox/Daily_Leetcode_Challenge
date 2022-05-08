function joinedLogger(level = 1, sep = "") {
  const f = (...messages) => {
    const filterdMesses = messages
      .filter((m) => m.level >= level)
      .map((m) => m.text)
      .join(sep);
    logger({ text: filterdMesses });
  };

  return f;
}

console.log(stripProperty({ a: 1, b: 2 }, "a"));
