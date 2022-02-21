export class RequestLogin{
  public nomeUsuario: string;
  public senha: string;
  private id: number;

    public getId(): number {
        return this.id;
    }

    public setId(id: number): void {
        this.id = id;
    }
}
