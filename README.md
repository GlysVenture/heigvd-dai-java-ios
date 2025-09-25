# Java IOs

## Benchmarks

### Write
| bytes_written   | 1   | 100 | 1K  | 10K | 100K | 1M   | 5M    | 10M   | 100M   |
|-----------------|-----|-----|-----|-----|------|------|-------|-------|--------|
| BINARY          | 113 | 130 | 133 | 167 | 444  | 3280 | 15971 | 32804 | 319051 |
| BUFFERED_BINARY | 120 | 133 | 129 | 138 | 134  | 138  | 151   | 194   | 728    |
| TEXT            | 124 | 154 | 146 | 133 | 147  | 173  | 158   | 407   | 2239   |
| BUFFERED_TEXT   | 116 | 133 | 130 | 135 | 131  | 152  | 250   | 204   | 738    |

### Read
| bytes_read      | 1   | 100 | 1K  | 10K | 100K | 1M  | 5M   | 10M  | 100M  |
|-----------------|-----|-----|-----|-----|------|-----|------|------|-------|
| BINARY          | 115 | 132 | 133 | 136 | 187  | 817 | 3687 | 6916 | 70119 |
| BUFFERED_BINARY | 113 | 127 | 132 | 129 | 130  | 144 | 139  | 172  | 605   |
| TEXT            | 118 | 131 | 133 | 136 | 160  | 148 | 152  | 274  | 1412  |
| BUFFERED_TEXT   | 113 | 135 | 138 | 133 | 132  | 152 | 206  | 185  | 632   |

We can observe that buffered is quite stable only having slightly longer times in files over 10M bytes.

Text unbuffered is also more weirdly more stable,
probably due to an internal buffer needed to precess multibyte encodings.
[FileReader](https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html) says it uses a buffer btw.

Of course plain binary suffers a lot from the single byte write or read syscalls.
