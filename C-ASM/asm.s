   1              		.file	"main.c"
   2              		.text
   3              	.Ltext0:
   4              		.cfi_sections	.debug_frame
   5              		.globl	i
   6              		.section .rdata,"dr"
   7              		.align 4
   8              	i:
   9 0000 02000000 		.long	2
  10              		.def	__main;	.scl	2;	.type	32;	.endef
  11 0004 00000000 		.text
  11      00000000 
  11      00000000 
  12              		.globl	main
  13              		.def	main;	.scl	2;	.type	32;	.endef
  14              		.seh_proc	main
  15              	main:
  16              	.LFB16:
  17              		.file 1 "main.c"
  18              		.loc 1 18 0
  19              		.cfi_startproc
  20 0000 55       		pushq	%rbp
  21              		.seh_pushreg	%rbp
  22              		.cfi_def_cfa_offset 16
  23              		.cfi_offset 6, -16
  24 0001 4889E5   		movq	%rsp, %rbp
  25              		.seh_setframe	%rbp, 0
  26              		.cfi_def_cfa_register 6
  27 0004 4883EC20 		subq	$32, %rsp
  28              		.seh_stackalloc	32
  29              		.seh_endprologue
  30 0008 894D10   		movl	%ecx, 16(%rbp)
  31 000b 48895518 		movq	%rdx, 24(%rbp)
  32              		.loc 1 18 0
  33 000f E8000000 		call	__main
  33      00
  34              		.loc 1 20 0
  35 0014 B8000000 		movl	$0, %eax
  35      00
  36              		.loc 1 21 0
  37 0019 4883C420 		addq	$32, %rsp
  38 001d 5D       		popq	%rbp
  39              		.cfi_restore 6
  40              		.cfi_def_cfa 7, 8
  41 001e C3       		ret
  42              		.cfi_endproc
  43              	.LFE16:
  44              		.seh_endproc
  45              		.globl	foo
  46              		.def	foo;	.scl	2;	.type	32;	.endef
  47              		.seh_proc	foo
  48              	foo:
  49              	.LFB17:
  50              		.loc 1 23 0
  51              		.cfi_startproc
  52 001f 55       		pushq	%rbp
  53              		.seh_pushreg	%rbp
  54              		.cfi_def_cfa_offset 16
  55              		.cfi_offset 6, -16
  56 0020 4889E5   		movq	%rsp, %rbp
  57              		.seh_setframe	%rbp, 0
  58              		.cfi_def_cfa_register 6
  59              		.seh_endprologue
  60              		.loc 1 25 0
  61 0023 5D       		popq	%rbp
  62              		.cfi_restore 6
  63              		.cfi_def_cfa 7, 8
  64 0024 C3       		ret
  65              		.cfi_endproc
  66              	.LFE17:
  67              		.seh_endproc
  68              	.Letext0:
  69 0025 90909090 		.section	.debug_info,"dr"
  69      90909090 
  69      909090
  70              	.Ldebug_info0:
  71 0000 C8010000 		.long	0x1c8
  72 0004 0400     		.word	0x4
  73 0006 00000000 		.secrel32	.Ldebug_abbrev0
  74 000a 08       		.byte	0x8
  75 000b 01       		.uleb128 0x1
  76 000c 474E5520 		.ascii "GNU C 4.9.2 -fpreprocessed -mtune=haswell -march=x86-64 -g\0"
  76      4320342E 
  76      392E3220 
  76      2D667072 
  76      6570726F 
  77 0047 01       		.byte	0x1
  78 0048 6D61696E 		.ascii "main.c\0"
  78      2E6300
  79 004f 433A5C5C 		.ascii "C:\\\\JavaProjects\\\\GIT\\\\Kaputnik120\\\\C-ASM\0"
  79      4A617661 
  79      50726F6A 
  79      65637473 
  79      5C5C4749 
  80 0079 00000000 		.quad	.Ltext0
  80      00000000 
  81 0081 25000000 		.quad	.Letext0-.Ltext0
  81      00000000 
  82 0089 00000000 		.secrel32	.Ldebug_line0
  83 008d 02       		.uleb128 0x2
  84 008e 01       		.byte	0x1
  85 008f 06       		.byte	0x6
  86 0090 63686172 		.ascii "char\0"
  86      00
  87 0095 02       		.uleb128 0x2
  88 0096 08       		.byte	0x8
  89 0097 07       		.byte	0x7
  90 0098 6C6F6E67 		.ascii "long long unsigned int\0"
  90      206C6F6E 
  90      6720756E 
  90      7369676E 
  90      65642069 
  91 00af 02       		.uleb128 0x2
  92 00b0 08       		.byte	0x8
  93 00b1 05       		.byte	0x5
  94 00b2 6C6F6E67 		.ascii "long long int\0"
  94      206C6F6E 
  94      6720696E 
  94      7400
  95 00c0 02       		.uleb128 0x2
  96 00c1 02       		.byte	0x2
  97 00c2 07       		.byte	0x7
  98 00c3 73686F72 		.ascii "short unsigned int\0"
  98      7420756E 
  98      7369676E 
  98      65642069 
  98      6E7400
  99 00d6 02       		.uleb128 0x2
 100 00d7 04       		.byte	0x4
 101 00d8 05       		.byte	0x5
 102 00d9 696E7400 		.ascii "int\0"
 103 00dd 02       		.uleb128 0x2
 104 00de 04       		.byte	0x4
 105 00df 05       		.byte	0x5
 106 00e0 6C6F6E67 		.ascii "long int\0"
 106      20696E74 
 106      00
 107 00e9 03       		.uleb128 0x3
 108 00ea 08       		.byte	0x8
 109 00eb 8D000000 		.long	0x8d
 110 00ef 02       		.uleb128 0x2
 111 00f0 04       		.byte	0x4
 112 00f1 07       		.byte	0x7
 113 00f2 756E7369 		.ascii "unsigned int\0"
 113      676E6564 
 113      20696E74 
 113      00
 114 00ff 02       		.uleb128 0x2
 115 0100 08       		.byte	0x8
 116 0101 07       		.byte	0x7
 117 0102 73697A65 		.ascii "sizetype\0"
 117      74797065 
 117      00
 118 010b 02       		.uleb128 0x2
 119 010c 04       		.byte	0x4
 120 010d 07       		.byte	0x7
 121 010e 6C6F6E67 		.ascii "long unsigned int\0"
 121      20756E73 
 121      69676E65 
 121      6420696E 
 121      7400
 122 0120 02       		.uleb128 0x2
 123 0121 01       		.byte	0x1
 124 0122 08       		.byte	0x8
 125 0123 756E7369 		.ascii "unsigned char\0"
 125      676E6564 
 125      20636861 
 125      7200
 126 0131 02       		.uleb128 0x2
 127 0132 08       		.byte	0x8
 128 0133 04       		.byte	0x4
 129 0134 646F7562 		.ascii "double\0"
 129      6C6500
 130 013b 02       		.uleb128 0x2
 131 013c 04       		.byte	0x4
 132 013d 04       		.byte	0x4
 133 013e 666C6F61 		.ascii "float\0"
 133      7400
 134 0144 02       		.uleb128 0x2
 135 0145 10       		.byte	0x10
 136 0146 04       		.byte	0x4
 137 0147 6C6F6E67 		.ascii "long double\0"
 137      20646F75 
 137      626C6500 
 138 0153 04       		.uleb128 0x4
 139 0154 6D61696E 		.ascii "main\0"
 139      00
 140 0159 01       		.byte	0x1
 141 015a 12       		.byte	0x12
 142 015b D6000000 		.long	0xd6
 143 015f 00000000 		.quad	.LFB16
 143      00000000 
 144 0167 1F000000 		.quad	.LFE16-.LFB16
 144      00000000 
 145 016f 01       		.uleb128 0x1
 146 0170 9C       		.byte	0x9c
 147 0171 94010000 		.long	0x194
 148 0175 05       		.uleb128 0x5
 149 0176 61726763 		.ascii "argc\0"
 149      00
 150 017b 01       		.byte	0x1
 151 017c 12       		.byte	0x12
 152 017d D6000000 		.long	0xd6
 153 0181 02       		.uleb128 0x2
 154 0182 91       		.byte	0x91
 155 0183 00       		.sleb128 0
 156 0184 05       		.uleb128 0x5
 157 0185 61726776 		.ascii "argv\0"
 157      00
 158 018a 01       		.byte	0x1
 159 018b 12       		.byte	0x12
 160 018c 94010000 		.long	0x194
 161 0190 02       		.uleb128 0x2
 162 0191 91       		.byte	0x91
 163 0192 08       		.sleb128 8
 164 0193 00       		.byte	0
 165 0194 03       		.uleb128 0x3
 166 0195 08       		.byte	0x8
 167 0196 E9000000 		.long	0xe9
 168 019a 06       		.uleb128 0x6
 169 019b 666F6F00 		.ascii "foo\0"
 170 019f 01       		.byte	0x1
 171 01a0 17       		.byte	0x17
 172 01a1 1F000000 		.quad	.LFB17
 172      00000000 
 173 01a9 06000000 		.quad	.LFE17-.LFB17
 173      00000000 
 174 01b1 01       		.uleb128 0x1
 175 01b2 9C       		.byte	0x9c
 176 01b3 07       		.uleb128 0x7
 177 01b4 6900     		.ascii "i\0"
 178 01b6 01       		.byte	0x1
 179 01b7 0B       		.byte	0xb
 180 01b8 C6010000 		.long	0x1c6
 181 01bc 09       		.uleb128 0x9
 182 01bd 03       		.byte	0x3
 183 01be 00000000 		.quad	i
 183      00000000 
 184 01c6 08       		.uleb128 0x8
 185 01c7 D6000000 		.long	0xd6
 186 01cb 00       		.byte	0
 187              		.section	.debug_abbrev,"dr"
 188              	.Ldebug_abbrev0:
 189 0000 01       		.uleb128 0x1
 190 0001 11       		.uleb128 0x11
 191 0002 01       		.byte	0x1
 192 0003 25       		.uleb128 0x25
 193 0004 08       		.uleb128 0x8
 194 0005 13       		.uleb128 0x13
 195 0006 0B       		.uleb128 0xb
 196 0007 03       		.uleb128 0x3
 197 0008 08       		.uleb128 0x8
 198 0009 1B       		.uleb128 0x1b
 199 000a 08       		.uleb128 0x8
 200 000b 11       		.uleb128 0x11
 201 000c 01       		.uleb128 0x1
 202 000d 12       		.uleb128 0x12
 203 000e 07       		.uleb128 0x7
 204 000f 10       		.uleb128 0x10
 205 0010 17       		.uleb128 0x17
 206 0011 00       		.byte	0
 207 0012 00       		.byte	0
 208 0013 02       		.uleb128 0x2
 209 0014 24       		.uleb128 0x24
 210 0015 00       		.byte	0
 211 0016 0B       		.uleb128 0xb
 212 0017 0B       		.uleb128 0xb
 213 0018 3E       		.uleb128 0x3e
 214 0019 0B       		.uleb128 0xb
 215 001a 03       		.uleb128 0x3
 216 001b 08       		.uleb128 0x8
 217 001c 00       		.byte	0
 218 001d 00       		.byte	0
 219 001e 03       		.uleb128 0x3
 220 001f 0F       		.uleb128 0xf
 221 0020 00       		.byte	0
 222 0021 0B       		.uleb128 0xb
 223 0022 0B       		.uleb128 0xb
 224 0023 49       		.uleb128 0x49
 225 0024 13       		.uleb128 0x13
 226 0025 00       		.byte	0
 227 0026 00       		.byte	0
 228 0027 04       		.uleb128 0x4
 229 0028 2E       		.uleb128 0x2e
 230 0029 01       		.byte	0x1
 231 002a 3F       		.uleb128 0x3f
 232 002b 19       		.uleb128 0x19
 233 002c 03       		.uleb128 0x3
 234 002d 08       		.uleb128 0x8
 235 002e 3A       		.uleb128 0x3a
 236 002f 0B       		.uleb128 0xb
 237 0030 3B       		.uleb128 0x3b
 238 0031 0B       		.uleb128 0xb
 239 0032 27       		.uleb128 0x27
 240 0033 19       		.uleb128 0x19
 241 0034 49       		.uleb128 0x49
 242 0035 13       		.uleb128 0x13
 243 0036 11       		.uleb128 0x11
 244 0037 01       		.uleb128 0x1
 245 0038 12       		.uleb128 0x12
 246 0039 07       		.uleb128 0x7
 247 003a 40       		.uleb128 0x40
 248 003b 18       		.uleb128 0x18
 249 003c 9642     		.uleb128 0x2116
 250 003e 19       		.uleb128 0x19
 251 003f 01       		.uleb128 0x1
 252 0040 13       		.uleb128 0x13
 253 0041 00       		.byte	0
 254 0042 00       		.byte	0
 255 0043 05       		.uleb128 0x5
 256 0044 05       		.uleb128 0x5
 257 0045 00       		.byte	0
 258 0046 03       		.uleb128 0x3
 259 0047 08       		.uleb128 0x8
 260 0048 3A       		.uleb128 0x3a
 261 0049 0B       		.uleb128 0xb
 262 004a 3B       		.uleb128 0x3b
 263 004b 0B       		.uleb128 0xb
 264 004c 49       		.uleb128 0x49
 265 004d 13       		.uleb128 0x13
 266 004e 02       		.uleb128 0x2
 267 004f 18       		.uleb128 0x18
 268 0050 00       		.byte	0
 269 0051 00       		.byte	0
 270 0052 06       		.uleb128 0x6
 271 0053 2E       		.uleb128 0x2e
 272 0054 00       		.byte	0
 273 0055 3F       		.uleb128 0x3f
 274 0056 19       		.uleb128 0x19
 275 0057 03       		.uleb128 0x3
 276 0058 08       		.uleb128 0x8
 277 0059 3A       		.uleb128 0x3a
 278 005a 0B       		.uleb128 0xb
 279 005b 3B       		.uleb128 0x3b
 280 005c 0B       		.uleb128 0xb
 281 005d 11       		.uleb128 0x11
 282 005e 01       		.uleb128 0x1
 283 005f 12       		.uleb128 0x12
 284 0060 07       		.uleb128 0x7
 285 0061 40       		.uleb128 0x40
 286 0062 18       		.uleb128 0x18
 287 0063 9742     		.uleb128 0x2117
 288 0065 19       		.uleb128 0x19
 289 0066 00       		.byte	0
 290 0067 00       		.byte	0
 291 0068 07       		.uleb128 0x7
 292 0069 34       		.uleb128 0x34
 293 006a 00       		.byte	0
 294 006b 03       		.uleb128 0x3
 295 006c 08       		.uleb128 0x8
 296 006d 3A       		.uleb128 0x3a
 297 006e 0B       		.uleb128 0xb
 298 006f 3B       		.uleb128 0x3b
 299 0070 0B       		.uleb128 0xb
 300 0071 49       		.uleb128 0x49
 301 0072 13       		.uleb128 0x13
 302 0073 3F       		.uleb128 0x3f
 303 0074 19       		.uleb128 0x19
 304 0075 02       		.uleb128 0x2
 305 0076 18       		.uleb128 0x18
 306 0077 00       		.byte	0
 307 0078 00       		.byte	0
 308 0079 08       		.uleb128 0x8
 309 007a 26       		.uleb128 0x26
 310 007b 00       		.byte	0
 311 007c 49       		.uleb128 0x49
 312 007d 13       		.uleb128 0x13
 313 007e 00       		.byte	0
 314 007f 00       		.byte	0
 315 0080 00       		.byte	0
 316              		.section	.debug_aranges,"dr"
 317 0000 2C000000 		.long	0x2c
 318 0004 0200     		.word	0x2
 319 0006 00000000 		.secrel32	.Ldebug_info0
 320 000a 08       		.byte	0x8
 321 000b 00       		.byte	0
 322 000c 0000     		.word	0
 323 000e 0000     		.word	0
 324 0010 00000000 		.quad	.Ltext0
 324      00000000 
 325 0018 25000000 		.quad	.Letext0-.Ltext0
 325      00000000 
 326 0020 00000000 		.quad	0
 326      00000000 
 327 0028 00000000 		.quad	0
 327      00000000 
 328              		.section	.debug_line,"dr"
 329              	.Ldebug_line0:
 330 0000 3B000000 		.section	.debug_str,"dr"
 330      02001D00 
 330      00000101 
 330      FB0E0D00 
 330      01010101 
 331              		.ident	"GCC: (GNU) 4.9.2"
