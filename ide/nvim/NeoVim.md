# So Far
## 📄 NeoVim Setup Progress (Windows, Minimal)

### ✅ 1. Installed NeoVim

- Verified with `nvim --version`
    
- Using **NeoVim v0.11.0** with **LuaJIT**
    

---

### ✅ 2. Created Initial Config

- Path: `%LOCALAPPDATA%\nvim\init.lua`
    
- This file holds your NeoVim configuration (like `~/.vimrc` for Vim)
    

---

### ✅ 3. Bootstrapped `lazy.nvim`

- Downloaded `lazy.nvim` if missing
    
- Set it up as the plugin manager
    
- Added to runtime path via `vim.opt.rtp:prepend(...)`
    

---

### ✅ 4. Installed Essential Plugins

```lua
"williamboman/mason.nvim",           -- Tool installer
"williamboman/mason-lspconfig.nvim", -- LSP installer wrapper
"neovim/nvim-lspconfig"              -- Native LSP support
```

---

### ✅ 5. Setup `mason` and LSP for Java

```lua
require("mason").setup()
require("mason-lspconfig").setup({
  ensure_installed = { "jdtls" },
})
```

- Mason handles downloading tools (like Java LSP)
    

---

### ✅ 6. Configured Java LSP (`jdtls`)

```lua
local lspconfig = require("lspconfig")
lspconfig.jdtls.setup({
  cmd = { "jdtls" }
})
```

- Tells NeoVim how to launch the Java language server
    

---

### ✅ 7. Added LSP Keymaps (via `LspAttach`)

```lua
vim.api.nvim_create_autocmd('LspAttach', {
  callback = function(ev)
    local opts = { buffer = ev.buf }
    vim.keymap.set('n', 'gd', vim.lsp.buf.definition, opts)
    vim.keymap.set('n', 'K', vim.lsp.buf.hover, opts)
    vim.keymap.set('n', '<leader>rn', vim.lsp.buf.rename, opts)
  end
})
```

- Adds useful LSP keybindings only when LSP is active
    

---

Let me know when you’re ready to add:

- **Auto-completion** with `nvim-cmp`
    
- **Snippet support**
    
- **Java formatting**
    
- Or a file explorer like `nvim-tree`
    

Your NeoVim is lean, mean, and just got its license to thrill. 😎